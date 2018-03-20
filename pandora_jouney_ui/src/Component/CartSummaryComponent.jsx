import React, { Component } from 'react'
// import PropTypes from 'prop-types'
// import ProductCardComponent from './ProductCardComponent'


class CartSummaryComponent extends Component {
    render() {
        return (
            <div>
                <span className="glyphicon glyphicon glyphicon-shopping-cart">&nbsp;{this.props.itemCount}</span>
            </div>);
    }

}

// CartDetailsComponent.propTypes = {
//     products: PropTypes.array.isRequired,
//     onDetailsClick: PropTypes.func.isRequired,
// };

export default CartSummaryComponent;