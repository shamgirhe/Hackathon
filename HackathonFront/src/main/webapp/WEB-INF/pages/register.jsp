<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Registration Page</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        margin: 0;
        padding: 0;
      }

      .container {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        text-align: center;
        background-color: white;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
      }

      .container h1 {
        color: #333;
        margin-bottom: 20px;
      }

      table {
        width: 100%;
        border-collapse: collapse;
      }

      table td {
        padding: 10px;
        border: none;
      }

      input {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 5px;
      }

      input:focus {
        border-color: #666;
        outline: none;
      }

      input[type="submit"] {
        background-color: #28a745;
        color: white;
        border: none;
        border-radius: 5px;
        padding: 10px;
        cursor: pointer;
        transition: background-color 0.3s;
      }

      input[type="submit"]:hover {
        background-color: #218838;
      }

      label {
        text-align: left;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h1>Registration Page</h1>
      <form method="post" action="ctl?page=NewUserAdded">
        <table>
          <tr>
            <td><label for="fullName">full Name</label></td>
            <td>
              <input
                type="text"
                id="fullName"
                name="fullName"
                placeholder="Enter First Name"
                required
              />
            </td>
          </tr>
          <tr>
            <td><label for="phoneNumber">Phone Number</label></td>
            <td>
              <input
                type="text"
                id="phoneNumber"
                name="phoneNumber"
                placeholder="Enter Phone Number"
                required
              />
            </td>
          </tr>
          <tr>
            <td><label for="email">Email</label></td>
            <td>
              <input
                type="text"
                id="email"
                name="email"
                placeholder="Enter Email"
                required
              />
            </td>
          </tr>
          <tr>
            <td><label for="password">Password</label></td>
            <td>
              <input
                type="password"
                id="password"
                placeholder="Enter Password"
                name = "password"
                required
              />
            </td>
          </tr>
          <tr>
            <td colspan="2" align="center">
              <input type="submit" value="Submit" />
            </td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>