import {printLOG} from './utility.js';

//click: 鼠标点击事件
document.querySelector('#b2').addEventListener('click', () => {
    printLOG("我被点击了...");
})

//mouseenter: 鼠标移入
document.querySelector('#last').addEventListener('mouseenter', () => {
    printLOG("鼠标移入了...");
})

//mouseleave: 鼠标移出
document.querySelector('#last').addEventListener('mouseleave', () => {
    printLOG("鼠标移出了...");
})

//keydown: 某个键盘的键被按下
document.querySelector('#username').addEventListener('keydown', () => {
    printLOG("键盘被按下了...");
})

//keyup: 某个键盘的键被抬起
document.querySelector('#username').addEventListener('keyup', () => {
    printLOG("键盘被抬起了...");
})

//blur: 失去焦点事件
document.querySelector('#age').addEventListener('blur', () => {
    printLOG("失去焦点...");
})

//focus: 元素获得焦点
document.querySelector('#age').addEventListener('focus', () => {
    printLOG("获得焦点...");
})

//input: 用户输入时触发
document.querySelector('#age').addEventListener('input', () => {
    printLOG("用户输入时触发...");
})

//submit: 提交表单事件
document.querySelector('form').addEventListener('submit', () => {
    alert("表单被提交了...");
})