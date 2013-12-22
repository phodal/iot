
var dataLength = [];

function drawTemp() {
    var zero = [];
    $.getJSON('/athome/', function(json) {
        var items = [];
        dataLength.push(json.length);
        $.each(json, function(key, val) {
            zero.push(val.temperature);
        });
        if (zero.length > 30) {
            for (var i = 0; i < zero.length - 31; i++) zero.shift();
        }
        chart = new Highcharts.Chart({
            color: {
                linearGradient: {
                    x1: 0,
                    x2: 0,
                    y1: 0,
                    y1: 1
                },
                stops: [
                    [0, '#003399'],
                    [1, '#3366AA']
                ]
            },
            chart: {
                renderTo: 'Tchart',
                type: 'spline'
            },
            title: {
                text: '本月温度情况'
            },
            subtitle: {
                text: ''
            },
            xAxis: {
                categories: [],
                title: {
                    text: ''
                }
            },
            yAxis: {
                title: {
                    text: '温度 (°C)'
                }
            },
            tooltip: {
                backgroundColor: '#FCFFC5',
                borderColor: 'black',
                borderRadius: 10,
                borderWidth: 1,
                enabled: true,
                formatter: function() {
                    return '<b>' + this.series.name + '</b><br/>' + this.x + ': ' + this.y + '°C';
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -10,
                y: 100,
                borderWidth: 0
            },
            plotOptions: {
                line: {
                    dataLabels: {
                        enabled: true
                    },
                    enableMouseTracking: false
                }
            },
            series: [{
                name: '本月',
                data: zero
            }, {
                name: '对比',
                data: [26.0]
            }]
        });
    });
};

function showTemper() {
    var length = dataLength[0];
    $.ajax({
        url: '/athome/' + length,
        type: 'GET',
        dataType: 'json',
        async: true,
        timeout: 1000,
        error: function() {},
        success: function(sdata) {
            $('.temperStatus').empty();
            $('.temperStatus').append(sdata.temperature);
        }
    });
};

$(document).ready(function() {
    setInterval("drawTemp();", 5000);
    setInterval("showTemper();", 800);
    drawTemp();
    showTemper();
});