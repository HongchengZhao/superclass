import React from 'react'
import { Button } from 'react-native-elements';

export default HeaderRightButton = props => {
    const {
        icon,
        ...attributes
    } = props

    return (
        <Button
            clear
            title=''
            icon={icon}
            iconContainerStyle={{ margin: 3, alignItems: 'center', justifyContent: 'center' }}
            buttonStyle={{
                margin: 13,
                width: 30,
                height: 30,
                backgroundColor: 'transparent',
                borderRadius: 30
            }}
            {...attributes}
        />
    )
}