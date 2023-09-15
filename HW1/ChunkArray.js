var chunk = function(arr, size) {
    let result = [];
    for (i = 0; i < arr.length; i += size) {
        result.push(arr.slice(i, i+size))
    }
    return result
};