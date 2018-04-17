<template>
    <div class='maxheigh'>
        <Layout class='maxheigh'>
            <Header>Header</Header>
            <Content class='layout-content'>

                <Card class='login-card' @keyup="login">
                    <div style="text-align:center">
                        <p class='login-tilte' slot="title">登陆</p>
                        <div class='login-content'>
                            <Input class='login-input' v-model="username" :icon='usericon' :value="username" clearable autofocus>
                            <span slot="prepend">
                                <Icon type="person"></Icon>
                            </span>
                            </Input>
                            <Input class='login-input' v-model="password" :type='passtype' :icon='passicon' :value="password" @on-click='showPassword'>
                            <span slot="prepend">
                                <Icon type="locked"></Icon>
                            </span>
                            </Input>
                            <Checkbox v-model="remember">记住密码</Checkbox><br>
                            <Button class='login-button' type="primary" @click="login">登陆</Button>
                        </div>
                    </div>
                </Card>

            </Content>
        </Layout>
    </div>
</template>
<script>
export default {
    data() {
        return {
            remember: true,
            username: localStorage.username,
            password: localStorage.password,
            isShow: true,
            write: false,
        }
    },
    created() {
        let $this = this;
        document.onkeyup = function(e) {
            let key = e.keyCode
            if(key == 13){
                $this.login()
            }
        }
    },
    computed: {
        usericon: function() {
            return this.username ? 'close' : ''
        },
        passicon: function() {
            return this.isShow ? 'eye' : 'eye-disabled'
        },
        passtype: function() {
            return this.isShow ? 'password' : 'text'
        }
    },
    methods: {
        showPassword: function() {
            this.isShow = this.isShow ? false : true;
        },
        login: function() {
            let $this = this
            this.$ajax({
                method: 'POST',
                url: '/sys/login',
                data: {
                    username: $this.username,
                    password: $this.password
                }
            }).then(function(res) {
                if (res.data.code == '200') {
                    if ($this.remember) {
                        localStorage.username = $this.username
                        localStorage.password = $this.password
                    } else {
                        localStorage.username = ''
                        localStorage.password = ''
                    }
                    $this.$store.commit('LOGIN', res.data.user)
                    $this.$router.push('/home')
                } else {
                    $this.errorModal("登陆失败")
                }
            })
        }
    }
}
</script>
<style scoped>
.layout-content {
    height: calc(100% - 24px);
}

.login-card {
    width: 300px;
    top: 30%;
    margin-left: auto;
    margin-right: auto;
}

.login-tilte {
    font-size: 30px;
    font-weight: bold;
}

.login-content {
    text-align: left;
}

.login-content>* {
    width: 266px;
    margin-bottom: 20px;
}
</style>
