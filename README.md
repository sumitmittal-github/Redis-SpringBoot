# Spring Data Redis

<p>
	This repository contains the implementation of Spring Data Redis
</p>



<p> 
	REST Clients to test the Microservices are - <br/>
	1. Add chrome extension :	ReqBin HTTP Client (https://reqbin.com/)  <br/>
	2. Add chrome extension :	Talend API Tester - Free Edition <br/>
</p>
<br/> <br/>



<p> 
	checking the cache in Redis CLI - <br/>
	1. to list all the keys -
	command :   keys *
	output  : 	"student::1"

	2. to get key by id -
	command :   get student::1
	output  : 	<serialized student object>

	3. to delete all the keys from the cache -
	command :   flushall

	4. to delete 1 key from the cache -
	command :   del student::1
</p>
<br/> <br/>



<p>
	API-1 : To get all Students from DB - <br/>
	GET : http://localhost:8080/student
</p>
<br/>

<p>
	API-2 : To get Student by Id from DB - <br/>
	GET : http://localhost:8080/student/1
</p>
<br/>

<p>
	API-3 : To create a Student in DB - <br/>
	POST : http://localhost:8080/student
	
	Body : 
	{
	   "firstName": "Maulik",
	   "lastName": "Mittal",
	   "age": 6,
	   "emailId": "maulik@gmail.com"
	 }
</p>
<br/>

<p>
	API-4 : To update a Student in DB - <br/>
	PUT : http://localhost:8080/student
	
	Body : 
	{
	   "id": 3,
	   "firstName": "Maulik",
	   "lastName": "Mittal",
	   "age": 6,
	   "emailId": "maulik_new_email_id@gmail.com"
	 }
</p>
<br/>

<p>
	API-5 : To delete a Student from DB - <br/>
	DELETE : http://localhost:8080/student/3
</p>
<br/>
