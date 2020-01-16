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
  let bookingTime = new Date(localStorage.getItem("time"));
  let hairstyle = localStorage.getItem("style");

  let fName = document.getElementById("inputFirstName").value;
  let lName = document.getElementById("inputLastName").value;
  let emailAddress = document.getElementById("inputEmail").value;
  let phone = document.getElementById("inputPhone").value;
  alert("name " + fName + " " + lName + " booking time " + bookingTime);

  // axios
  //   .post("http://localhost:8081/createBooking", {
  //     style: hairstyle,
  //     timeOfBooking: bookingTime
  //   })
  //   .then()
  axios
    .post("http://localhost:8081/createCustomer", {
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
    })
    .then(location.assign("confirmation-page.html"));
}

function showBooking() {
  axios.get("/BookingSystem/findAllCustomers").then(response => {
    cust = response.data[response.data.length - 1];
    let appmntDate = new Date(cust.bookings[0].timeOfBooking);
    let text = document.createElement("p");
    text.innerHTML =
      "Thanks for booking with us " +
      cust.firstName +
      "!" +
      " We look forward to seeing you on " +
      appmntDate.toDateString() +
      " at " +
      appmntDate.toTimeString().substring(0, 5) +
      ".";
    let confPage = document.getElementById("confirmation");
    confPage.appendChild(text);
  });
}

function disableTimes(selected) {
  axios.get("/BookingSystem/findAllBookings").then(response => {
    let bookings = response.data;
    let times = [];
    let days = [];
    for (let i of bookings) {
      var bt = new Date(i.timeOfBooking);
      days.push(bt.toUTCString());
    }
    if (days.includes(selected)) {
      alert("Sorry the time you have selected is taken.");
    }

    // days.push(
    //   String(bt.getDate()).padStart(2, "0") +
    //     "/" +
    //     String(bt.getMonth()).padStart(2, "0") +
    //     "/" +
    //     String(bt.getFullYear())
    // );
    // times.push(bt.getHours() + ":" + bt.getMinutes() + 0);
    // }
  });
}
