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
    }
    alert("You selected " + hairstyle);
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

  axios.post("http://localhost:8081/createBooking", {
    style: hairstyle,
    timeOfBooking: bookingTime
  });

  axios.post("http://localhost:8081/createCustomer", {
    firstName: "name",
    lastName: "nameagain",
    email: "emailaddress",
    phoneNumber: "1291029109",
    bookings: [
      {
        style: hairstyle,
        timeOfBooking: bookingTime
      }
    ]
  });
}
