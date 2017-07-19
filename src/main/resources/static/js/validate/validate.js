/**
 * Created by liu.yang on 2017/7/19.
 */
jQuery.extend({
    validateUnnormal:function(s){
        return /^[A-Za-z0-9][A-Za-z0-9]+$/i.test(s);
    },
    validateEmail:function (s) {
        return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(s);
    },
    validatePasswordSimilar:function (s1,s2) {
        return s1 == s2;
    }
    
});