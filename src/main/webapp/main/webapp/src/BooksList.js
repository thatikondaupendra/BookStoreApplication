import React, { Component } from "react"; 
 
import axios from "axios"; 
import { NavLink } from "react-router-dom"; 
import { Modal } from "react-bootstrap"; 
import Container from "react-bootstrap/Container"; 
import Button from "react-bootstrap/Button"; 
 
class BooksList extends Component { 
  state = { 
    mybooks: [], 
    showConfirm: false, 
    mybookIdToDelete: "", 
  }; 
 
  componentDidMount() { 
    console.log("componentDidMount"); 
    this.getAllBooks(); 
  } 
 
 
  getAllBooks = () => { 
    const URL = "http://localhost:5500/myapi/mybooks"; 
    console.log(URL); 
    axios.get(URL).then((myresponse) => { 
      console.log(myresponse.data); 
      // console.log(myresponse.headers); 
      this.setState({ 
        mybooks: myresponse.data, 
      }); 
    }); 
  }; 
 
  showDeleteConfim = (mybookId) => { 
    console.log("showDeleteConfim", mybookId); 
    this.setState({ 
      showConfirm: true, 
      mybookIdToDelete: mybookId, 
    }); 
  }; 
 
  hideDeleteConfim = () => { 
    console.log("hideDeleteConfim"); 
    this.setState({ 
      showConfirm: false, 
    }); 
  }; 
handleDelete = () => { 
console.log("handleDelete", this.state.mybookIdToDelete); 
 
const URL = `http://localhost:5500/myapi/mybooks/${this.state.mybookIdToDelete}`; 
axios.delete(URL) 
.then((myresponse) => { 
console.log(1, myresponse.data); 
this.hideDeleteConfim(); 
this.getAllBooks(); 
this.props.history('/'); 
}) 
.catch((myerror) => { 
console.log(2, myerror); 
}); 
}; 
 
 
 
 
 
 
  render() { 
    const mybooksList = this.state.mybooks.map((mybook) => { 
      return ( 
        <tr key={mybook.bookId}> 
          <td> {mybook.bookId} </td> 
          <td> {mybook.bookName} </td> 
          <td> {mybook.author} </td> 
          <td> {mybook.price} </td> 
          <td> {mybook.category} </td> 
          <td> {mybook.publications} </td> 
 
          <td> 
            <NavLink key={mybook.bookId} to={`/edit-book/${mybook.bookId}`} 
              className="btn btn-primary mytext-large mymargin1" exact> 
              Edit {mybook.bookId}
            </NavLink> 
 
            <button   type="button"  data-toggle="modal"  
              data-target="#BookDeleteConfirmation" 
              onClick={this.showDeleteConfim.bind(this, mybook.bookId)} 
              className="btn btn-danger mytext-large mymargin1"    > 
              Delete Book 
            </button> 
          </td> 
        </tr> 
      ); 
    }); 
 
    return ( 
      <Container className="span-viewport d-flex flex-column align-items-center"> 
        <br /> 
        <div className="container"> 
          <div className="myfloat-left"> 
            <span className="text-center mytext-extra-large"> 
              Books @ Java Learning Center 
            </span> 
          </div> 
          <div className="myfloat-right"> 
            <NavLink   to={"/add-book"}  
              className="btn btn-primary mytext-large mymargin1" exact > 
              Add Book 
            </NavLink> 
          </div> 
        </div> 
 
 
      <table className="table"> 
          <thead> 
            <tr> 
              <th> Book ID</th> 
              <th> Book Name</th> 
              <th> Author</th> 
              <th> Price</th> 
              <th> Category</th> 
              <th> Publications</th> 
              <th> </th> 
            </tr> 
          </thead> 
          <tbody>{mybooksList}</tbody> 
        </table> 
 
        <Modal show={this.state.showConfirm} onHide={this.hideDeleteConfim}> 
          <Modal.Header closeButton> 
            <Modal.Title>Confirmation</Modal.Title> 
          </Modal.Header> 
          <Modal.Body> 
            <p>Are you sure to delete?</p> 
            <b>{this.state.mybookIdToDelete}</b> 
          </Modal.Body> 
          <Modal.Footer> 
            <Button variant="secondary" onClick={this.hideDeleteConfim}> 
              Close 
            </Button> 
            <Button variant="danger" onClick={this.handleDelete}> 
              Delete 
            </Button> 
          </Modal.Footer> 
        </Modal> 
      </Container> 
    ); 
  } 
} 
export default BooksList; 
