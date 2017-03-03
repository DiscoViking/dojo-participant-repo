import * as _ from 'lodash'

let what_is_q = /what is ([0-9]+) plus ([0-9]+)/;
// let what_is_q = /what is ([0-9]+) plus ([0-9]+)/;
let which_largest = /^.* largest: (.*)/; 

export function respondTo(query: string): string {
    let m = what_is_q.exec(query)
    if(m) {
        return (parseInt(m[1]) + parseInt(m[2])).toString();
    }

    m = which_largest.exec(query);
    if(m) {
        let str = m[1];
        let arr = str.split(", ");
        console.log(arr);
        return _.max(_.map(arr, parseInt)).toString();
    }
    return `Unknown query '${query}'`;
}

