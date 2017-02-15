/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
 Array.prototype.bubblesort = function() {
     var done = false;
     while (! done) {
         done = true;
         for (var i = 1; i < this.length; i++) {
             if (this[i - 1] > this[i]) {
                 done = false;
                 var tmp = this[i - 1];
                 this[i - 1] = this[i];
                 this[i] = tmp;
             }
         }
     }
     return this;
 }
var app = {
    // Application Constructor
    initialize: function() {
        this.bindEvents();
    },
    // Bind Event Listeners
    //
    // Bind any events that are required on startup. Common events are:
    // 'load', 'deviceready', 'offline', and 'online'.
    bindEvents: function() {
        document.addEventListener('deviceready', this.onDeviceReady, false);
    },
    // deviceready Event Handler
    //
    // The scope of 'this' is the event. In order to call the 'receivedEvent'
    // function, we must explicitly call 'app.receivedEvent(...);'
    onDeviceReady: function() {
        var start = new Date().getTime();
        var array = app.geraVector(100000);
        array.bubblesort();

        $.each(array, function(){
            $('#order').append(this + " ,");
        });
        $('#time').text((new Date().getTime() - start)/1000);
    },
     geraVector: function(size) {
         var vector = [];
         for(var i = size; i > 0; i--) {
             vector.push(i);
          }
         return vector;
     }
};

app.initialize();