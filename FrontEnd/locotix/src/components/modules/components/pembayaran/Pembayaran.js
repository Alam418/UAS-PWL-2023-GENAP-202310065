import React from 'react'
import { Link } from 'react-router-dom';

export default function Pembayaran() {

  const harga = localStorage.getItem('harga');

  return (
    <div className='container mt-5'>
      <div className="container">
        <form>
          <div className='row'>
            <div className='col-md-8'>
              <h2>Detail Pemesan</h2>
              <div className="row">
                <div className="col-md-6 my-2">
                  <div className="form-group">
                    <label for="first">No. Rekening</label>
                    <input type="text" className="form-control" placeholder="" id="first" />
                  </div>
                </div>

                <div className="col-md-6 my-2">
                  <div className="form-group">
                    <label for="last">Nama</label>
                    <input type="text" className="form-control" placeholder="" id="last" />
                  </div>
                </div>
              </div>

              <div className="row">
                <div className="col-md-6 my-2">
                  <div className='row'>
                    <div className='col'>
                      <div className="form-group">
                        <label for="phone">Expire</label>
                        <input type="tel" className="form-control" id="phone" placeholder="phone" />
                      </div>
                    </div>
                    <div className='col'>
                      <div className="form-group">
                        <label for="phone">CCV</label>
                        <input type="tel" className="form-control" id="phone" placeholder="phone" />
                      </div>
                    </div>
                  </div>
                </div>

                <div className="col-md-6 my-2">
                  <div className="form-group">
                    <label for="company">Jumlah Dibayar</label>
                    <input type="text" className="form-control" placeholder={harga} id="company" readOnly disabled/>
                  </div>
                </div>
              </div>

              <Link to='/tiket_kereta'>
                <button type="submit" className="btn btn-success mt-3 w-100">Bayar</button>
              </Link>
            </div>
            <div className='col'>
              <img src={require("../../../../components/assets/media/visa.jpg")} alt="ibik-logo"
                style={{ width: "150%" }} />
            </div>
          </div>
        </form>
      </div>
    </div>
  )
}
