import React from 'react'
import { Container, Row } from 'reactstrap'

const Footer = () => {
  return (
   <Container className="footer bottom bg-light bg-gradient rounded-top border-top border-5" fluid>
    <Container className="mt-1 text-center">
      <Row>        
        <div className="mx-auto pt-3">
          <p className="mb-0 font-weight-bold">&copy; 2022 Naim Arif</p>
          <hr className="my-0 bg-secondary"/>
          <p className="mb-0">email: thk.naim@gmail.com</p>
          
        </div>
      </Row>      
    </Container>
    </Container>
  )
}

export default Footer