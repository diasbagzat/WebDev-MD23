var createCounter = function(init) {
    let preInit = init
    return {
        increment: () => ++preInit,
        decrement: () => --preInit,
        reset: () => preInit = init,
    }
};