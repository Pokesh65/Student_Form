
import { useState } from 'react';
import './App.css';
import'./Components/Assets/Stylef.css'
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import Accordion from 'react-bootstrap/Accordion';

function App() {
    const[Inp,SetInp]=useState({Fname:" ",Sname:" ",Mid:" ",Pno:" ",Cname:" ",Rno:" "})

    function ChangeValue(e){
        SetInp({...Inp,[e.target.name]:e.target.value})

    }
    
    async function SendDatas(){
        // e.preventDefault()
        const {data}=await axios.post("http://localhost:8080/Form/EnterData",{
            f_Name:Inp.Fname,
            s_name:Inp.Sname,
            mail_id:Inp.Mid,
            phone_no:Inp.Pno,
            course_name:Inp.Cname,
            reg_no:Inp.Rno
             })
         console.log(data)
        }
  
  const Navi=useNavigate()

  function sendResult(){

      Navi("/result") 
  }

    
return(
    <div className="all_body">
    <div class="box">
              <form action="">
              <h2>Student Details</h2>
              <div class="inputrow">
                  <div class="inputbox">
                  <ion-icon name="person-outline"></ion-icon>
                      <input type="text" name='Fname' id="Fname" placeholder=" " onChange={(e)=>ChangeValue(e)} required/>
                      <label for="">First  Name:</label>
    
                  </div>
                  <div class="inputbox1">
                      <ion-icon name="people-outline"></ion-icon>
                      <input type="text" name='Sname' id="Sname" placeholder=" " onChange={(e)=>ChangeValue(e)} required/>
                      <label for="">Second Name:</label>
                  </div>
              </div>
              <div class="inputrow">
                  <div class="inputbox">
                      <ion-icon name="mail-unread-outline"></ion-icon>
                      <input type="email" name='Mid' id="Mid" placeholder=" " onChange={(e)=>ChangeValue(e)} required/>
                      <label for="">Email:</label>
                      
                  </div>
                  <div class="inputbox1">
                      <ion-icon name="call-outline"></ion-icon>
                      <input type="number" name='Pno' id="Pno" placeholder=" " onChange={(e)=>ChangeValue(e)} required/>
                      <label for="">Contact No:</label>
                  </div>
              </div>
              <div class="inputrow">
                  <div class="inputbox">
                      <ion-icon name="school-outline"></ion-icon>
                      <input type="text" name='Cname' id="Cname" placeholder=" " onChange={(e)=>ChangeValue(e)} required/>
                      <label for="">Course Name:</label>
                      
                  </div>
                  <div class="inputbox1">
                      <ion-icon name="server-outline"></ion-icon>
                      <input type="number" name='Rno' id="Rno" placeholder=" "  onChange={(e)=>ChangeValue(e)} required/>
                      <label for="">Register No:</label>
                  </div>
              </div>
             <div class="Btn-div">
                  <button class="Btn1 button-Home" onClick={()=>SendDatas()}>Submit</button>
                  <button class="Btn2 button-Home" onClick={()=>sendResult()}>Result</button>
                  
             </div>

          </form>

       </div>
    
    </div>

    )
}


export default App;
