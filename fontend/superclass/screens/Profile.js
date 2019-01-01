import React, { Component } from 'react';
import {
  AsyncStorage,
  View,
  Button,
  Text
} from 'react-native';

export default class Profile extends Component{
    static navigationOptions = {
        title: 'User',
    };

    render(){
        return(
            <Text>USer Info</Text>
        )
    }
}