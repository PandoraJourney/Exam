import React, {Component} from 'react'
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import {Link} from 'react-router'
import image from './samsung.jpg'

class ProductDetailsComponent extends Component{ 
    render(){
        var itemsHtml = this.props.products.providers.map((item, index) => {
            // var url = '/services/' + item.id;
            return (
              <tr key={index}>
                <td>{index + 1}</td>
                {/* <td><img src={item.image} /></td> */}
                {/* <td><Link to={url}>{item.title}</Link></td> */}
                <td>{item.title}</td>
                <td>Price: {item.price} EUR</td>
              </tr>
            );
          });
        return (
        <div>
            <div className="media">
                <div className="media-left">
                    <img className="media-object" src={image} alt="..." />
                </div>
                <div className="media-body">
                    <h4 className="media-heading">{this.props.product.title}</h4>
                    <p>{this.props.product.description}</p>
                    <table className="table">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>Title</th>
                        </tr>
                      </thead>
                      <tbody>
                        {itemsHtml}
                      </tbody>
                    </table>
                </div>
            </div>
            <div className="help-text">
                <div style={{ paddingTop: '10px' }}>
                    <button style={{ marginRight: '10px' }} className="btn btn-success" onClick={this.props.onAddToCart}>To cart</button>
                    <button style={{ marginRight: '10px' }} className="btn btn-default" onClick={this.props.onBack}>Back</button>
                </div>
            </div>
        </div>);
           }
}


export default ProductDetailsComponent;