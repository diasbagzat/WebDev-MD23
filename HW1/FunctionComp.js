var compose = function(functions) {
	return function(x) {
        functions.reduceRight((total, op) => {
            total = op(x);
            x = total;
        }, x)
        return x;
    }
};