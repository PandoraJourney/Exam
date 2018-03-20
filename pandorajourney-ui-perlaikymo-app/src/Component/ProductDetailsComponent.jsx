import React, {Component} from 'react'
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import image from './samsung.jpg'

class ProductDetailsComponent extends Component{ 
    render(){
        return (
        <div>
            <div className="media">
                <div className="media-left">
                    <img className="media-object" src={image} alt="..." />
                </div>
                <div className="media-body">
                    <h4 className="media-heading">{this.props.product.title}</h4>
                    <p>{this.props.product.description}</p>
                    <p>{this.props.product.isInStock}</p>
                    <p>Price: {this.props.product.price} Eur</p>
                </div>
            </div>
            <div className="help-text">
                <div style={{ paddingTop: '10px' }}>
                    <button style={{ marginRight: '10px' }} className="btn btn-success" onClick={this.props.onAddToCart}>To cart</button>
                    <button style={{ marginRight: '10px' }} className="btn btn-default" onClick={this.props.onBack}>Back</button>
                </div>
            </div>
        </div>
    );}
}


export default ProductDetailsComponent;