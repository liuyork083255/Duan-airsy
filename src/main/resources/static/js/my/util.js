/**
 * Created by Administrator on 2017/7/23.
 */
jQuery.extend({
    S4:function () {
        return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
    },
    getUUID:function () {
        return ($.S4()+$.S4()+""+$.S4()+""+$.S4()+""+$.S4()+""+$.S4()+$.S4()+$.S4());
    },
});