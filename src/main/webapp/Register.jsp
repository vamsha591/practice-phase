<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Register</title>
   
</head>
<body>
    
     
      <br>
      
       
        <h1 >REGISTRATION FORM</h1>
        <div id="form">
            <form method="post" action="MyServlet">
                <table id="table">
                    <tr>
                        <td>FIRST NAME:</td>
                        <td>
                            <input type="text" name="fName" 
                            maxlength="30" placeholder="Enter first name" required/>
                          
                        </td>
                    </tr>
                    <tr>
                        <td>LAST NAME:
                            </td>
                        <td><input type="text" name="lName" 
                            maxlength="30" placeholder="Enter last name" required/> 
                            
                            </td>
                    </tr>
                    <tr>
                    <tr>
                        <td>EMAIL ID:
                            </td>
                        <td><input id="email" type="email" name="email"  maxlength="100" placeholder="Enter Email" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Phone NO:
                            
                        </td>
                        <td><input type="tel" name="phno"  maxlength="12" placeholder="Enter Mobile no" required/>
                            
                          
                        </td>
                            
                    </tr>
           
                <tr>
                    <td >Languages:</td>
                    <td><input id="C" type="checkbox" name="lang" value="C" checked="checked"/>
                        <label for="C">C</label>
                        <input id="C++" type="checkbox" name="lang" value="C++" checked="checked"/>
                        <label for="C++">C++</label>
                        <input id="JAVA" type="checkbox" name="lang" value="JAVA" checked="checked"/>
                        <label for="JAVA">JAVA</label>
                       
                        
                        </td>
                </tr>
                <tr>
                    <td>
                        <button type="submit">Submit</button>
                        <button type="reset">Reset</button>
                       
                </td>
                </tr>

                    
                
                    


                    
                </table>
            </form>


        </div>
 
        
</body>
</html>