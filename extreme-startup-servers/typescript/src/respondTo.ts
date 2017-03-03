import * as _ from 'lodash'

let what_is_q = /what is ([0-9]+) .* ([0-9]+)/;
// let which_largest = /
export function respondTo(query: string): string {
    let m = what_is_q.exec(query)
    if(m) {
        return (parseInt(m[0]) + parseInt(m[1])).toString();
    }    
    return `Unknown query '${query}'`;
}

