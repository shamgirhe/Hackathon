<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Login Page</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
      }

      table {
        width: 100%;
        border-collapse: collapse;
      }

      table td {
        padding: 10px;
        border: none;
      }

      input,a{
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 5px;
      }

      input,a:focus {
        border-color: #666;
        outline: none;
      }

      input[type="submit"],a {
        background-color: #28a745;
        color: white;
        border: none;
        border-radius: 5px;
        padding: 10px;
        cursor: pointer;
        transition: background-color 0.3s;
      }

      input[type="submit"],a:hover {
        background-color: #218838;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h1>Login Page</h1>
      <form method="post" action="ctl?page=login">
        <table>
          <tr>
            <td><label for="uname">Email</label></td>
            <td>
              <input
                type="text"
                id="uname"
                name="email"
                placeholder="Enter Email"
                required
              />
            </td>
          </tr>
          <tr>
            <td><label for="psw">Password</label></td>
            <td>
              <input
                type="password"
                id="psw"
                name="password"
                placeholder="Enter Password"
                required
              />
            </td>
          </tr>
          <tr>
            <td colspan="2" align="center">
              <input type="submit" value="Sign In" />
            </td>
          </tr>
        </table>
      </form>
      <table>
      <tr>
            <td colspan="2" align="center">
              <a href="ctl?page=register">Sign Up</a>
                          </td>
          </tr>
      </table>
    </div>
  </body>
</html>
