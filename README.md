# 2024_SolutionChallenge_EmergencyMate

## 🎯 Introduction
A patient died of cardiac arrest at a university hospital in South Korea after waiting for a long time.The hospital allegedly lefted the patient because he appeared to be sleeping. This case highlights the difficulty of managing long waiting lists in busy hospitals, and is a very serious issue that can lead to patient death in the worst case scenario. The hospital's solution to this problem is to increase nursing staffing, as well as CCTV and monitoring. However, nursing staffing is already understaffed, making round-the-clock staffing inefficient, and CCTV monitoring can't really detect patients in cardiac arrest. EmergencyMate can detect when a patient really needs help by utilizing the call bell function, allowing nursing staff to focus their attention on that moment, enabling efficient nursing staff utilization and patient care. EmergencyMate also utilizes an Arduino device to check the actual heart rate and make an immediate call in case of a problem to actually solve the problem.

## 📽 Demo Video
<a href="https://github.com/leaf1191">![youtube](https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/65040981-53b2-4bac-8212-c41469ac1d50)

## 🛠 Architecture
![architecture](https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/d1ec5fd8-d7fb-46a7-9e19-a9660e269b45)

## ❓️ How to use
### 1. Login
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/7b0c3ec1-3242-4e9f-b710-fa907b72b8d7" width = 300 height = 600>

You can sign in to Google Social with the sign-in button in the center.

### 2. Select
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/e4ed2709-6cf9-48f6-bcec-bea47e0c0396" width = 300 height = 600>

Select a role type. Selecting Patient will take you to the Patient page, and selecting Admin will take you to the Admin page. Once you make a selection, you can't change it back until you log out.

### 3. Patient Page
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/fb29bc23-069a-47ea-8235-330d925edd67" width = 300 height = 600>

The patient main page supports logging out and navigating to various pages. The following are the main features of the patient page

#### 3.1. Heart Beat
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/dd55fb5d-c80b-4005-97fb-a3c26fd0b140" width = 300 height = 600>

This is the heart rate measurement page. Click the Bluetooth button at the bottom to connect with your Bluetooth device. If it is successfully connected, it detects your heart rate in real time and calls the administrator if there is a problem. A warning sound will sound when it is called.

#### 3.2. Wait Info
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/7990f916-7653-4b4e-bb66-49a608a1aace" width = 300 height = 600>

<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/272bc88a-ed63-450e-a1a9-1e0c77ae1652" width = 300 height = 600>

This is the waiting information confirmation page. The left screen appears when you are not registered and the right screen appears when you are registered, and you can check your input information and waiting number.

#### 3.3. Call Bell
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/a2db6911-e27d-47a6-bbfd-588c516f4ff5" width = 300 height = 600>

This is the call bell. It's designed to be pressed for 3 seconds to activate, to prevent curious or accidental presses from causing confusion. A loud beep sounds when you call it. It must be registered to be called. 

#### 3.4. When Admin Call
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/d606ac86-6adf-41ff-bbff-64c0510e0432" width = 300 height = 600>

This is the screen that the admin goes to when the patient is called. Patients cannot move themselves, but can only log out. When you log out, you are deleted from the admin list, and the patient is notified that it's their turn, which helps to keep things running smoothly.

### 4. Admin Page
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/b0dcbe73-e938-427c-a855-00820565355e" width = 300 height = 600>

<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/1aa23e99-f777-4f6f-bfaa-d23af394a3f9" width = 300 height = 600>

This is the administrator screen. In addition to the logout button, you can check the registered patients in the grid system, call the patient's turn, and delete the patient from the grid. Click a patient to see their registered information. Click Add at the top to add unregistered patients.

#### 4.1. Patient Register
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/1d062760-3bae-4d51-8e17-eb1485f22314" width = 300 height = 600>

<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/4af9ad0e-29b0-4c4c-b0c8-7206b240160e" width = 300 height = 600>

This is the Add unregistered patient screen. Click the field in the list to go to the creation page and register details on the creation page. Once successfully registered, they will be added to the waiting grid.

#### 4.2. When Patient Call
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/c009af5f-df10-4017-b63b-e8eade903d28" width = 300 height = 600>

This is the screen that changes when a patient calls in. If even one patient is paged, a beep sounds and you can end the call by confirming the patient.

## 💡 Contributors
<table>
  <tbody>
    <tr>
      <td align="center" valign="top" width="200"><img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/7ae8661c-e289-4957-a7fc-022cca93c930" width = 200 height = 200>
      <td align="center" valign="top" width="200"><img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/146098855/ede0a4d1-da68-441c-92a1-006035ba1e32" width = 200 height = 200>
      <td align="center" valign="top" width="200"><img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/104562082/76af99bd-04d1-4267-955a-f2a505909876" width = 200 height = 200>
      <td align="center" valign="top" width="200"><img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/109638538/cc7b794e-1485-4383-9bcc-227e31f4d5ab" width = 200 height = 200>  
    </tr>
    <tr>
      <td align="center" valign="top" width="200"><a href="https://github.com/leaf1191"><sub><b>심종우</b></sub>
      <td align="center" valign="top" width="200"><a href="https://github.com/zhyunn"><sub><b>김지현</b></sub>
      <td align="center" valign="top" width="200"><a href="https://github.com/Hyerim20"><sub><b>강혜림</b></sub>
      <td align="center" valign="top" width="200"><a href="https://github.com/Nayeon-2"><sub><b>이나연</b></sub>  
    </tr>
    <tr>
      <td align="center" valign="top" width="200"><sub><b>Flutter, Firebase</b></sub>
      <td align="center" valign="top" width="200"><sub><b>Spring, Firebase</b></sub>
      <td align="center" valign="top" width="200"><sub><b>Spring, Firebase</b></sub>
      <td align="center" valign="top" width="200"><sub><b>Arduino, Video Editing</b></sub> 
    </tr>
  </tbody>
</table>
