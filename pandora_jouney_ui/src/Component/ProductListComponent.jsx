import React, { Component } from 'react'
import PropTypes from 'prop-types'
import ProductCardComponent from './ProductCardComponent'


class ProductListComponent extends Component {
    render() {
        if (this.props.products.length !== 0) {
            var productCards = this.props.products.map((product, index) => {
                return (
                    <ProductCardComponent
                        key={index}
                        id={product.id}
                        image={product.image}
                        title={product.title}
                        description={product.description}
                        price={product.price}
                        onDetailsClick={this.props.onDetailsClick} />
                );
            });
            return (<div className="row">{productCards}</div>);
        }
        else {
            return (<div> Laukiu duomenu </div>);
        }
    }

}

ProductListComponent.propTypes = {
    products: PropTypes.array.isRequired,
    onDetailsClick: PropTypes.func.isRequired,
};

export default ProductListComponent;