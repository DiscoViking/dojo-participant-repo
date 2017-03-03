import * as _ from 'lodash'

let what_is_q = /what is ([0-9]+) plus ([0-9]+)/;
let minus_q = /what is ([0-9]+) minus ([0-9]+)/;
// let what_is_q = /what is ([0-9]+) plus ([0-9]+)/;
let which_largest = /^.* largest: (.*)$/; 
let spain = /Spain/;
let primes = /primes: (\d+), (\d+)$/;

export function respondTo(query: string): string {
    let m = what_is_q.exec(query)
    if(m) {
        return (parseInt(m[1]) + parseInt(m[2])).toString();
    }

    m = minus_q.exec(query)
    if(m) {
        return (parseInt(m[1]) - parseInt(m[2])).toString();
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
    return `Unknown query '${query}'`;
}

function isPrime(v: number) {
    return false;
}