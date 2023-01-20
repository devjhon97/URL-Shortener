function encode(num){
    var newlink = '';
    var char = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'; 
    
    for(let index = 1; index<= num; index++){
        let num = Math.floor(Math.random()*char.length);
        newlink += char[num];
    }
    
    return newlink;
}

module.exports = encode;