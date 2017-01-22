# WebServices

Calculator HTML client
-http://localhost:8080/MyRESTWebService/CalculatorWebClient.html

-Calculator Service
GET

http://localhost:8080/MyRESTWebService/mywebservice/simplecalculator/<operation>/<op1>/<op2>

operation:{‘addition’,’subtraction’,’division’,’multiplication’}

-Temperature converter
GET

http://localhost:8080/MyRESTWebService/mywebservice/ctofservice

http://localhost:8080/MyRESTWebService/mywebservice/ftocservice

-Simple Library
GET

http://localhost:8080/MyRESTWebService/mywebservice/simplelibrary/produce/xml/<searchString>

http://localhost:8080/MyRESTWebService/mywebservice/simplelibrary/produce/json/<searchString>

searchString:{name:Harry%20Potter, author:JKRowling, etc}

POST

http://localhost:8080/MyRESTWebService/mywebservice/simplelibrary/consume/xml

Header:
ContentType: application/xml

Body example:
<book>
<bookAuthor>Oberoi</bookAuthor>
<bookName>Chemistry</bookName>
</book>


http://localhost:8080/MyRESTWebService/mywebservice/simplelibrary/consume/json

Header:
ContentType: application/json

Body example:
{"bookAuthor":"H.C. Verma","bookName":"Physics"}

Database Info:

Mongo DB
Database name: “webservices”
Collection name: “books”

DB Document example:
{ 
"_id" : ObjectId("587c32d8d4c61ebe339a7ab1"),
"id" : "ebd3fde8-745b-4e80-8122-1161a6b4c150",
"name" : "Physics",
"author" : "H.C. Verma" 
}

