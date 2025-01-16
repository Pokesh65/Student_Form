import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

function Update() {

  const [one, setOne] = useState({ f_Name: "", s_name: "", mail_id: "", phone_no: "", course_name: "", reg_no: "" });


  const Navi=useNavigate();
  const { ID } = useParams();


  async function getForUpdate() {
    const { data } = await axios.get(`http://localhost:8080/Form/GetDataById/${ID}`)
    console.log(data);
    setOne(data);

  }

  function ChangeUpdate(e) {
    setOne({ ...one, [e.target.name]: e.target.value })
    // console.log(one)

  }

  useEffect(() => {
    getForUpdate();
  }, [])

  async function UpdateDatas(e){
    e.preventDefault();
    await axios.post("http://localhost:8080/Form/Update/"+ID,one).then((res)=>{
      console.log(res)
      Navi("/result")
    })
  }

  function ClearAll(){
    // setOne({ f_Name: "", s_name: "", mail_id: "", phone_no: "", course_name: "", reg_no: "" });
    Navi("/result")
    

  }



  return (
    
    <div  className='Update-main-div'>
      <div className='Container'>
            <div>
            <label className='labeltag' for="Fn" >First Name</label><br/>
            <input id='Fn' type='text' className='lstInp'  name='f_Name' value={one.f_Name} onChange={(e) => ChangeUpdate(e)}></input>
            </div>
            <div>
            <label className='labeltag' for="Sn">Second Name</label><br/>
             <input id='Sn' type='text' className='lstInp'  name='s_name' value={one.s_name} onChange={(e) => ChangeUpdate(e)} ></input>
             </div>
             <div>
             <label className='labeltag' for="Ei">Email Id</label><br/>
             <input id='Ei' type='text' className='lstInp'  name='mail_id' value={one.mail_id} onChange={(e) => ChangeUpdate(e)} ></input>
             </div>
             <div>
             <label className='labeltag' for="Pn">Phone Number</label><br/>
             <input id='Pn' type='text' className='lstInp'  name='phone_no' value={one.phone_no} onChange={(e) => ChangeUpdate(e)} ></input>
             </div>
             <div>
             <label className='labeltag' for="Cn">Course Name</label><br/>
             <input id='Cn' type='text' className='lstInp'  name='course_name' value={one.course_name} onChange={(e) => ChangeUpdate(e)}></input>
             </div>
             <div>
             <label className='labeltag' for="Rn">Register Number</label><br/>
             <input id='Rn' type='text' className='lstInp'  name='reg_no' value={one.reg_no} onChange={(e) => ChangeUpdate(e)} ></input>
             </div>
          
        </div>
        <div>
        <center>        
          <div className='table-button'>
          <button className='lastBtn' onClick={(e)=>UpdateDatas(e)}>
            Submit
          </button>
          <button className='lastBtn' onClick={()=>ClearAll()}>Cancel</button>
        </div>
        </center>
      </div>
    </div>
  )
}

export default Update