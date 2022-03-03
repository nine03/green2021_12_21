const http = require('http');
const express = require('express');
const app = express();
const router = express.Router();
// post 데이터 전송
const bodyParser = require('body-parser');
const cors = require('cors');

// 미들웨어
app.use(bodyParser.urlencoded({extended:false})); 
app.use(bodyParser.json());
app.use(express.static(__dirname + "/public"))
app.use(cors());
// ejs 뷰엔진 설정
app.set("views", __dirname+"/views");
app.set("view engine", "ejs");

var carList = [
    {"no":"car-no"+1, "name":"Sonata", "price":3000, "company":"HYUNDAI", "year":2020},
    {"no":"car-no"+2, "name":"BMW", "price":7000, "company":"BMW", "year":2022},
    {"no":"car-no"+3, "name":"S80", "price":6000, "company":"VOLVO", "year":2021},
    {"no":"car-no"+4, "name":"K7", "price":3500, "company":"KIA", "year":2020}
];
var sequence = 5;
router.route("/car/list").get((req, res)=>{
    res.send({carList});
});

router.route("/car/input").post((req, res)=>{
    //POST 방식은 req.body에서 파라미터를 전달 받는다.
    var carData = {
        "no": "car-no"+sequence++,
        "name":req.body.name,
        "price":req.body.price,
        "company":req.body.company,
        "year":req.body.year,
    }
    console.log(carData);
    carList.push(carData);
    res.send({carList});
});

function findCar(no) {
    var car = null;
    for(var i=0; i<carList.length; i++) {
        if(carList[i].no == no) {
            car = carList[i];
            break;
        }
    }
    return car;
}
function findIndexByNo(no) {
    for(var i=0; i<carList.length; i++) {
        if(carList[i].no == no) {
            return i;
        }
    }
    return -1;
}
function findIndex(car) {
    for(var i=0; i<carList.length; i++) {
        if(carList[i].no == car.no) {
            return i;
        }
    }
    return -1;
}

router.route("/car/detail/:no").get((req, res)=>{
    console.log("GET - /car/detail/:no")
    var no = req.params.no;
    var car = findCar(no);
    req.app.render("car_detail", {"car": car}, (err, html)=>{
        if(err) throw err;
        res.end(html);
    });
});

router.route("/car/detail").get((req, res)=>{
    console.log("GET - /car/detail")
    var no = req.query.no;
    var car = findCar(no);
    req.app.render("car_detail", {"car": car}, (err, html)=>{
        if(err) throw err;
        res.end(html);
    });
});

router.route("/car/modify/:no").get((req, res)=>{
    console.log("GET - /car/modify")
    var no = req.params.no;
    var car = findCar(no);
    req.app.render("car_modify", {"car": car}, (err, html)=>{
        if(err) throw err;
        res.end(html);
    });
});

router.route("/car/modify").post((req, res)=>{
    //POST 방식은 req.body에서 파라미터를 전달 받는다.
    const no = req.body.no;
    var carData = {
        "no": no,
        "name":req.body.name,
        "price":req.body.price,
        "company":req.body.company,
        "year":req.body.year,
    }
    var idx = findIndexByNo(req.body.no);
    carList[idx] = carData;
    res.redirect("/car/list");
});

router.route("/car/delete/:no").get((req, res)=>{
    console.log("GET - /car/modify")
    var no = req.params.no;
    var index = findIndexByNo(no);
    if(index != -1) {
        carList.splice(index,1);
    }
    res.redirect("/car/list");
});

app.use("/", router);
var server = http.createServer(app);
server.listen(3000, ()=>{
    console.log("서버 실행 중 >>> http://localhost:3000 ...");
});