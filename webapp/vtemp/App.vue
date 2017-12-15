<template>
  <div>
    <mt-header title="首页">
      <mt-button icon="more" slot="right"></mt-button>
    </mt-header>
    <mt-tab-container v-model="active" swipeable="true">
      <mt-tab-container-item id="首页">
        <mt-cell v-for="n in 10" title="tab-container 1"></mt-cell>
      </mt-tab-container-item>
      <mt-tab-container-item id="订单">
        <mt-cell v-for="n in 5" title="tab-container 2"></mt-cell>
      </mt-tab-container-item>
      <mt-tab-container-item id="历史">
        <mt-cell v-for="n in 7" title="tab-container 3"></mt-cell>
      </mt-tab-container-item>
      <mt-tab-container-item id="我的">
        <mt-cell v-for="n in 7" title="tab-container 4"></mt-cell>
      </mt-tab-container-item>
    </mt-tab-container>
    <mt-tabbar v-model="active">
      <mt-tab-item id="首页">
        <img slot="icon" src="../img/money.png">
        首页
      </mt-tab-item>
      <mt-tab-item id="订单">
        <img slot="icon" src="../img/money.png">
        订单
      </mt-tab-item>
      <mt-tab-item id="历史">
        <img slot="icon" src="../img/money.png">
        历史
      </mt-tab-item>
      <mt-tab-item id="我的">
        <img slot="icon" src="../img/money.png">
        我的
      </mt-tab-item>
    </mt-tabbar>
  </div>
</template>

<script>
    import { Header, Tabbar, TabItem, TabContainer, TabContainerItem} from 'mint-ui';

    export default {
        data() {
            return {
                active: '首页'
            }
        },
        components: {
            'Header.name': Header,
            'Tabbar.name': Tabbar,
            'TabItem.name': TabItem,
            'TabContainer,name': TabContainer,
            'TabContainerItem.name': TabContainerItem
        },
        methods: {
        
        
        }
    };
</script>

<style>
  .mint-tab-container{
    height: calc(100% - 95px);
  }
  .mint-tab-container-wrap, .mint-tab-container-item{
    height: 100%;
  }
</style>