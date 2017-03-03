import * as _ from 'lodash'

let plus_q = /what is ([0-9]+) plus ([0-9]+)/;
let plus_plus_q = /what is ([0-9]+) plus ([0-9]+) plus ([0-9]+)/;
let minus_q = /what is ([0-9]+) minus ([0-9]+)/;
let mult_q = /what is ([0-9]+) multiply ([0-9]+)/;
let power = /^what is (\d+) to the power of (\d+)$/;
let which_largest = /^.* largest: (.*)$/; 
let spain = /Spain/;
let banana = /banana/;
let primes = /primes: (\d+), (\d+)$/;
let fib_seq = /Fibonacci/;

export function respondTo(query: string): string {
    let m = plus_plus_q.exec(query)
    if(m) {
        return (parseInt(m[1]) + parseInt(m[2]) + parseInt(m[3])).toString();
    }

    m = plus_q.exec(query)
    if(m) {
        return (parseInt(m[1]) + parseInt(m[2])).toString();
    }


    m = minus_q.exec(query)
    if(m) {
        return (parseInt(m[1]) - parseInt(m[2])).toString();
    }
    
    m = mult_q.exec(query)
    if(m) {
        return (parseInt(m[1]) * parseInt(m[2])).toString();
    }

    m = which_largest.exec(query);
    if(m) {
        let str = m[1];
        let arr = str.split(",");
        console.log(_.map(_.map(arr, (v: string) => v.trim()), parseInt));
        return _.max(_.map(arr, parseInt)).toString();
    }

    m = spain.exec(query);
    if(m) {
        return 'Peseta';
    }

    m = banana.exec(query);
    if(m) {
        return 'Yellow';
    }


    m = primes.exec(query)
    if(m) {
        let p1 = parseInt(m[1]);
        let p2 = parseInt(m[2]);
        if(isPrime(p1)) {
            return p1.toString();
        } else {
            return p2.toString();
        }
    }

    m = fib_seq.exec(query);
    if(m) {
        let n = parseInt(m[1]);
        return fib(n).toString();
    }

    m = power.exec(query);
    if(m) {
        let x1 = m[1];
        let x2 = m[2];
        return Math.pow(parseInt(x1), parseInt(x2)).toString();
    }

    return `Unknown query '${query}'`;
}

function isPrime(value: number) {
   for(var i = 2; i < value; i++) {
       if(value % i === 0) {
           return false;
       }
   }
   return value > 1;
}

function fib(n: number) {
    var v_1 = 0;
    var v_2 = 1;
    var f = 1;
    for(var i = 0; i < n; i++) {
        f = v_2 + v_1;
        v_1 = v_2;
        v_2 = f;
    }

    return f;
}