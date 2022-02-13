import React, {Component} from 'react';
import {Col, Row} from "reactstrap";

class CvProfile extends Component {
    render() {
        return (
            <div>
                <Row>
                    <Col xs={"12"}>
                        <Row>
                            <Col xs={"3"}>
                                {this.props.user}
                            </Col>
                        </Row>
                    </Col>
                </Row>
            </div>
        );
    }
}

export default CvProfile;