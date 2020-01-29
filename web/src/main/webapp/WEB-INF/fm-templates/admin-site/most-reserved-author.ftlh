<script>
    window.onload = function () {

        var chart = new CanvasJS.Chart("chartContainer", {
            animationEnabled: true,

            title:{
                text:"Najchętniej wypożyczany autor"
            },
            axisX:{
                interval: 1
            },
            axisY2:{
                interlacedColor: "rgba(1,77,101,.2)",
                gridColor: "rgba(1,77,101,.1)",
                title: "autorzy"
            },
            data: [{
                type: "line",
                dataPoints : dataPoints,
            }]
        });
        $.getJSON("/api/admin/mostreservedauthors", function(data) {
            $.each(data, function(key, value){
                dataPoints.push({x: value[0], y: parseInt(value[1])});
            });
            chart.render();
        })};
</script>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>