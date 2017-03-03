import * as _ from 'lodash'

let what_is_q = /what is ([0-9]+) plus ([0-9]+)/;
// let which_largest = /^.* largest: (.*)/; 
export function respondTo(query: string): string {
    let m = what_is_q.exec(query)
    if(m) {
        console.log(m);
        console.log(m[1]);
        console.log(m[2]);
        return (parseInt(m[0]) + parseInt(m[1])).toString();
    }    
    return `Unknown query '${query}'`;
}

