<template>
    <Modal v-model="isshow" :title="title" width="380" @on-ok='ok' @on-cancel='cancel'>
        <Form :model="data" :inline='inline'>
            <template v-for="item in columns">
                <FormItem :label="item.value+'：'" :key="item.id" :v-model="data[item.key]">
                    <Input v-model="data[item.key]" :readonly='readonly'></Input>
                </FormItem>
            </template>
        </Form>
        <!--<div slot="footer">
                <Button type="text" size="large"   >取消</Button>
                <Button type="primary" size="large"   >确定</Button>
            </div>-->
    </Modal>
</template>
<script>
export default {
    // name: 'mModal',
    data() {
        return {
            isshow: this.show
        }
    },
    computed: {
        params: function() {
            let array = [];
            for (x in this.data) {
                array.push(x, this.data.x);
            }
            console.log(array)
            return array
        },
        inline: function() {
            return Object.keys(this.columns).length > 8 ? true : false
        }

    },
    watch: {
        show(val) {
            this.isshow = val
        },
    },
    props: {
        title: {
            type: String
        },
        data: {
            type: Object
        },
        columns: {
            type: Array
        },
        show: {
            type: Boolean
        },
        readonly: {
            type: Boolean,
            default: false
        },
        ok: {
            type: Function,
            default:function (){

            }
        },
        cancel: {
            type: Function,
            default:function (){

            }
        },
    },
    methods: {
        getParams:function(){
            return this.data
        }
    }
}
</script>
