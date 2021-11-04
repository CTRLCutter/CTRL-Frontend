const {app, BrowserWindow} = require('electron');
const path = require('path');

let win;
let serverProcess;

function createWindow() {
    let platform = process.platform;
	
    let appUrl = 'http://localhost:8080';

    const openWindow = function () {
        mainWindow = new BrowserWindow({
            title: 'Demo',
            width: 640,
            height: 480
        });

        mainWindow.loadURL(appUrl);

        mainWindow.on('closed', function () {
            mainWindow = null;
        });
		
    };

    const startUp = function () {
        const requestPromise = require('minimal-request-promise');

        requestPromise.get(appUrl).then(function (response) {
            console.log('Server started!');
            openWindow();
        }, function (response) {
            console.log('Waiting for the server start...');

            setTimeout(function () {
                startUp();
            }, 200);
        });
    };

    startUp();
}

app.on('ready', createWindow);

app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') {
        app.quit()
    }
});

app.on('activate', () => {
    if (win === null) {
        createWindow()
    }
});