# OOP Parking Lot Program
- Parking lot final program for EECS 3311
- Users are able to Login to parking lot system and book parking spots
- Using CSV as a Database to store User and Customer data
- Demo can be seen at: https://drive.google.com/drive/folders/1Q-jOIDRU6ACzmbR8J7FUHq8WO6vrfW7P

<h2> Features Developed </h2>

- Login System
- Customer Registration
- Parking Spot booking System
- Payment System
- Admin Parking System



<h2> System Login</h2>
<img width="212" alt="Screen Shot 2022-01-09 at 1 15 25 PM" src="https://user-images.githubusercontent.com/42787576/148694984-9c16d4a9-edf3-4fb8-b073-2adbf8534f8f.png">
<br>
<h2> User Register</h2>

<img width="210" alt="Screen Shot 2022-01-09 at 1 16 43 PM" src="https://user-images.githubusercontent.com/42787576/148695037-5a35d476-7cf5-42cf-adb1-e00bbb6b8761.png">

- Once user has registered they are prompted with a success window and returned back to the login page
<img width="220" alt="Screen Shot 2022-01-09 at 1 18 11 PM" src="https://user-images.githubusercontent.com/42787576/148695098-698dcf72-4bed-4314-823d-59004b7625d4.png">

<h2>User Login Page</h2>

<img width="211" alt="Screen Shot 2022-01-09 at 1 18 38 PM" src="https://user-images.githubusercontent.com/42787576/148695115-c9fd2dac-bdc6-4205-93fb-9a5e8147c602.png">
- If the user is not yet registered, then they will be prompted to register. If they have an account then they will be logged in and brought to the <i> Customer Parking System</i>

<h2> Customer Parking System </h2>
 <img width="211" alt="Screen Shot 2022-01-09 at 1 19 20 PM" src="https://user-images.githubusercontent.com/42787576/148695139-c6dc6ad8-e97f-4e03-9903-099c0991c754.png">
Here they are able to book parking, View parking spots, log out, pay for parking as well as cancel an existing parking spot. 

<img width="212" alt="Screen Shot 2022-01-09 at 1 40 57 PM" src="https://user-images.githubusercontent.com/42787576/148695973-4bf926ed-8147-4a3b-b5d0-ebf955235971.png">

<h2> Admin System</h2>
- The administrator is able to Add and Remove parking officers as well as Update payments of users
<img width="210" alt="Screen Shot 2022-01-09 at 1 46 12 PM" src="https://user-images.githubusercontent.com/42787576/148696183-5b96e236-6d89-4c3a-8d30-333b6f1b70b3.png">
<h4> Adding Parking Officer</h4>


- When adding a parking officer, they must already be registered with an account. When they are registered they are given type <b><i>Customer</b></i>, Once they are promoted to a parking authority. There time changes to <b><i> Officer</b></i> and updated in the DB(CSV File) 
<img width="394" alt="Screen Shot 2022-01-09 at 1 47 14 PM" src="https://user-images.githubusercontent.com/42787576/148696218-5c15eeb6-ea43-4388-abf2-e5730c7fc81f.png">

<h4> Removing Parking Auth</h4>
- Officer is referanced through the email they are registered with and changed from type <b><i> Officer</b></i> to type <b><i>Customer</b></i> 
<img width="211" alt="Screen Shot 2022-01-09 at 1 50 32 PM" src="https://user-images.githubusercontent.com/42787576/148696334-908dd745-4992-4e5b-b221-23b65dd855dc.png">


