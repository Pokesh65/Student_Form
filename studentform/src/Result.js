import React, { useState } from 'react'
import axios from 'axios'
import './Components/Assets/Stylef.css'
import{useNavigate}from 'react-router-dom';
import { useEffect } from 'react'; 


const Result = () => {
  const[Res,SetRes]=useState([])

  const Navi=useNavigate()
    function GoBack(){
        Navi("/")
    }
    async function GetDatas(){
      const {data}=await axios.get("http://localhost:8080/Form/ListOfData")
      console.log(data)
      SetRes(data)
    }

    useEffect(()=>{
      GetDatas()
    },[])

    
    
  return (
    <div className='R_Box'>
        
                <div><h2 className='R_Heading'>Student Details</h2></div>
                <table>
                  <thead>
                    <tr>
                      <td>Student Id</td>
                      <td>First Name</td>
                      <td>Second Name</td>
                      <td>Mail Id</td>
                      <td>Phone No</td>
                      <td>Course Name</td>
                      <td>Register No</td>
                    </tr>
                  </thead>
                  <tbody>
                    {Res.map((e)=>(
                      <>
                     <tr>
                      <td><p>{e.stud_id}</p></td>
                      <td><p>{e.f_Name}</p></td>
                      <td><p>{e.s_name}</p></td>
                      <td><p>{e.mail_id}</p></td>
                      <td><p>{e.phone_no}</p></td>
                      <td><p>{e.course_name}</p></td>
                      <td><p>{e.reg_no}</p></td>
                    </tr>
                      </>
                    ))}
                  </tbody>
                </table>
                
                <button className='Rbtn' onClick={()=>GoBack()}>Home</button>
         
    </div>
  )
}

export default Result