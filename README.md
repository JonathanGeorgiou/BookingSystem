# Booking System
A simple booking system for a barber shop.

## Contents
* [Intro](#intro)
* [Technologies](#tech)
* [Testing](#test)
* [Browser Support](#support)


<a name="intro"></a>
## Intro
My goal was to make an OOP application with full CRUD functionality. I have made a simple booking system for a barber shop
The application supports creating new customers and boookings and storing them in an H2 database. 
The plan is to upgrade the database to a more permanent one such as MySQL in the future. The customer is able to browse the
app to find information about the shop, such as the barbers that work there and the hairstyles on offer, and then they are
able to go on and create their booking by selecting the style they want, the time and date of the booking, and finally enter
their personal details. After creating the booking they are then able to update their email address or cancel the booking altogether.

<a name="tech"></a>
## Technologies
* **Database**: H2 SQL Database.
* **Back-end**: Java with SpringBoot framework.
* **Front-end**: HTML, CSS, JavaScript.
* **Build Tools**: Maven.
* **Deployment**: Jenkins, Tomcat, AWS. Link to App - http://3.11.74.92:8181/BookingSystem/

<a name="test"></a>
## Testing
Unit Testing done with JUnit and Mockito with 83% line coverage.
 See [Surefire Report](https://github.com/JonathanGeorgiou/BookingSystem/blob/master/Docs/Surefire%20Report.pdf).

<a name="support"></a>
## Browser Support ##
![Chrome](https://raw.github.com/alrra/browser-logos/master/src/chrome/chrome_48x48.png) | ![Firefox](https://raw.github.com/alrra/browser-logos/master/src/firefox/firefox_48x48.png) | 
--- | --- | 
Latest ✔ | Latest ✔ |

<a name="author"></a>
## Author ##
Jonathan Georgiou for Strap and Scraper London Ltd.

