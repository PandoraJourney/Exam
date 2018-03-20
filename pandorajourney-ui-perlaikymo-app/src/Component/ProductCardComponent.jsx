import React, { Component } from 'react'
import PropTypes from 'prop-types'
import image from './samsung.jpg'

class ProductCardComponent extends Component {
    render() {
        var styles = {
            thumbnail: {
                maxWidth: '242px',
                textAlign: 'center',
                marginLeft: 'auto',
                marginRight: 'auto'
            },
            caption: {
                color: 'black'
            },
            image: { width: '100%', height: '200px', display: 'block' }
        };
        console.log(this.props.image);
        return (
            <div className="col-sm-6 col-md-4">
                <div className="thumbnail" style={styles.thumbnail}>
                    <img src={image} style={styles.image} alt="..." />
                    <div className="caption">
                        <h3>{this.props.title}</h3>
                        <p>{this.props.description}</p>
                        <p>{this.props.price} Eur</p>
                        <p><button className="btn btn-primary" role="button" onClick={this.props.onDetailsClick(this.props.id)}>Details</button></p>
                    </div>
                </div>
            </div>
        );
    }

}

ProductCardComponent.propTypes = {
    id: PropTypes.number.isRequired,
    image: PropTypes.string.isRequired,
    title: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    price: PropTypes.number.isRequired,
    onDetailsClick: PropTypes.func.isRequired,
};

export default ProductCardComponent;