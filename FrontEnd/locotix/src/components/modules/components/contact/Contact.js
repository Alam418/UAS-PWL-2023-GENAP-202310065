import React from 'react'

export default function Contact() {
  return (
    <div className="container mx-auto">
      <div className="row">
        <h1>Contact us</h1>
      </div>
      <div className="row-custom input-container">
        <div className="col-xs-12">
          <div className="styled-input wide">
            <textarea disabled required></textarea>
            <label className='text-dark'>Layanan Pelanggan (Customer Care) Saran, kritik, dan keluhan dapat disampaikan melalui e-mail atau telepon berikut : customer.care@Loco.co.id, 08xxxxxxxx <br/>
              Untuk pengaduan yang ingin dirahasiakan pelapornya, dapat disampaikan melalui e-mail berikut : Customer.S@Loco.co.id</label>
          </div>
        </div>
      </div>
    </div>
  )
}
