import React from 'react'
import Footer from './components/footers/Footer'
import Header from './components/headers/Header'

export default function Layouts(props) {
    return (
        <div id="main-layout">
            <Header />

            <main className='mt-20 py-10'>
                {props.children}
            </main>

            <Footer />
            {/* <ModalPopUp /> */}
        </div>
    )
}