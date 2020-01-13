function selectStyle() {
  const styleOptions = document.getElementsByName("optionsRadios");
  let hairstyle = "";

  for (var i = 0; i < styleOptions.length; i++) {
    if (styleOptions[i].checked) {
      hairstyle = hairstyle + styleOptions[i].value;
      // alert("you selected " + hairstyle);
      // axios.post("http://localhost:8081/createBooking", {
      //   style: hairstyle,
      //   timeOfBooking: "2012-08-23T18:25:43.511"
      // });
      alert(hairstyle);
    }
    localStorage.setItem("style", hairstyle);
    location.assign("select-datetime.html");
  }
}

function selectTime() {
  var bookingTime = new Date($("#picker").val());
  alert(bookingTime);
  localStorage.setItem("time", bookingTime);
  location.assign("enter-details.html");
}

function confirmBooking() {
  let bookingTime = localStorage.getItem("time");
  let hairstyle = localStorage.getItem("style");
  let fName = document.getElementById("inputFirstName").value;
  let lName = document.getElementById("inputLastName").value;
  let emailAddress = document.getElementById("inputEmail").value;
  let phone = document.getElementById("inputPhone").value;
  alert("name " + fName + lName + "booking time " + bookingTime);

  axios.post("/BookingSystem/createBooking", {
    style: hairstyle,
    timeOfBooking: bookingTime
  });

  axios.post("/BookingSystem/createCustomer", {
    firstName: fName,
    lastName: lName,
    email: emailAddress,
    phoneNumber: phone,
    bookings: [
      {
        style: hairstyle,
        timeOfBooking: bookingTime
      }
    ]
  });
}
