function selectStyle() {
  const styleOptions = document.getElementsByName("optionsRadios");
  let hairstyle = "";

  for (var i = 0; i < styleOptions.length; i++) {
    if (styleOptions[i].checked) {
      hairstyle = hairstyle + styleOptions[i].value;
    }
    localStorage.setItem("style", hairstyle);
    location.assign("select-datetime.html");
  }
}

function selectTime() {
  var bookingTime = new Date($("#picker").val());
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

  axios
    .post(PATH + "createCustomer", {
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
  axios.get(PATH + "findAllCustomers").then(response => {
    let cust = response.data[response.data.length - 1];
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
    let confPage = document.getElementById("message");
    confPage.appendChild(text);
  });
}

function disableTimes(data) {
  axios.get(PATH + "findAllBookings").then(response => {
    let selected = data.toUTCString().substring(0, 22);
    let bookings = response.data;
    let times = [];
    let days = [];
    for (let i of bookings) {
      var bt = new Date(i.timeOfBooking);
      days.push(bt.toUTCString().substring(0, 22));
    }
    if (days.includes(selected)) {
      alert("Sorry the time you have selected is taken.");
      $("#picker").datetimepicker({
        showApplyButton: false
      });
    } else {
      $("#picker").datetimepicker({
        showApplyButton: true
      });
    }
  });
}
function deleteBooking() {
  axios.get(PATH + "findAllCustomers").then(response => {
    let cust = response.data[response.data.length - 1];
    axios.delete(PATH + "deleteCustomer/" + cust.id).then(response => {
      alert(
        cust.firstName + " " + cust.lastName + "'s booking has been canceled"
      );
      location.assign("index.html");
    });
  });
}
