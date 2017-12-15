/**
 * Created by jinyingfei on 2017/11/16.
 */
const webpack = require('webpack');
const path = require('path'); // 导入路径包
const glob = require('glob');//同步检查html
const htmlPlugin=require('html-webpack-plugin');
const PurifyCSSPlugin = require("purifycss-webpack");//去除多余的css样式的插件
const ExtractTextPlugin = require("extract-text-webpack-plugin");
module.exports = {
    entry: "./index.js", // 入口文件
    // 输出文件 build下的bundle.js
    output: {
        path: path.resolve(__dirname, 'build'),
        filename: "bundle.js",
        publicPath: "/build/"
    },
    devServer:{
        //服务器的IP地址，可以使用IP也可以使用localhost
        host:'localhost',
        //服务端压缩是否开启
        compress:false,
        //配置服务端口号
        port:8080,
        inline: true
    },
    resolve: {
        alias: {
            'vue': 'vue/dist/vue.min.js'
        }
    },
    // 使用loader模块
    module: {
        rules: [
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            },
            {
                test: /\.css$/,
                use: ExtractTextPlugin.extract({
                    fallback: "style-loader",
                    use: "css-loader"
                })
            },
            {
                test: /\.js$/,//js5转6
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ['es2015']
                    }
                }]
            },{
                test:/\.(png|jpe?g|gif|svg)(\?.*)?$/,
                use:[{
                    loader:'url-loader',//小于500000b的url-loader转换，大于的交给file-loader
                    options:{//url内置了file 只需要引url-loader 大于的会自动交给file处理
                        limit:500000, //将小于500000b的文件打成base64的格式写入js
                    }
                }]
            },
            {
                test: /\.(htm|html)$/i,//img图片正确路径配置
                use:[ 'html-withimg-loader']
            },
            {
            test: /\.(woff|woff2|svg|eot|ttf)\??.*$/,
            loader: 'file-loader?name=/font/[name].[ext]'
        }]

    },
    plugins: [
        new ExtractTextPlugin("[name].css", {allChunks: true}),
        new webpack.optimize.UglifyJsPlugin({       //代码编译后压缩
            compress: {
                warnings: false
            },
            output: {
                comments: true
            }
        }),
        new htmlPlugin({
            minify:{
                removeAttributeQuotes:true//是对html文件进行压缩，removeAttrubuteQuotes是却掉属性的双引号。
            },
            hash:true,//为了开发中js有缓存效果，所以加入hash，这样可以有效避免缓存JS。
            template:'./index.html'//是要打包的html模版路径和文件名称。
        }),
        new PurifyCSSPlugin({
            // Give paths to parse for rules. These should be absolute!
            paths: glob.sync(path.join(__dirname, './*.html')),
        })//用于删减多余的css样式

    ]

};
