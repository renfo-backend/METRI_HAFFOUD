import React from "react"
import  ButtonRadioProps from "../type/form/buttonradio_props.ts"

const CustomButtonRadio: React.FC<ButtonRadioProps> = ({ value , type, checked, onChange }) =>
    <div>
        <label htmlFor="inline-radio" className="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300 mx-1">{value}</label>
        <input onChange={onChange} checked={checked} id="inline-radio" type={type} value={value} name="inline-radio-group" className="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
    </div>

export default CustomButtonRadio
