import React, {Component} from 'react'
import ProductListAdministrationComponent from '../Component/ProductListAdministrationComponent'
import PropTypes from 'prop-types'
import axios from 'axios'
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';


class ProductListAdministrationContainer extends Component{
    
     constructor(context) {
        super(context)
        this.state = { services: [],
                        providers:[],
                      type1:'' ,
                      type2:''};
      }
    
      componentWillMount() {
        axios.get('https://localhost:8080/services/all').then((response) => {
          this.setState(()=>{return{ services: response.data} });
        });
        axios.get('https://localhost:8080/providers/all').then((response) => {
          this.setState(()=>{return{ providers: response.data} });
        });
      }
    
      render() {
        return (
          <div>
            <table className="table">
                      <thead>
                        <tr>
                          <th>Services</th>
                          <th>Providers</th>
                        </tr>
                      </thead>
                      <tbody>
                      <tr>
                          <td><ProductListAdministrationComponent products={this.state.service} type={"service"} /></td>
                        <td><ProductListAdministrationComponent products={this.state.providers} type={"provider"}/></td>
                        </tr>
                      </tbody>
                    </table>
            </div>
        );
      }
    }
    
    ProductListAdministrationComponent.contextTypes = {
      router: PropTypes.object.isRequired,
    };
    
export default ProductListAdministrationContainer;