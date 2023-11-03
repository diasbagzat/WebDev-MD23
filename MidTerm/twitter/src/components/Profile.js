import React, { useState } from 'react';
import '../Profile.css';

const Profile = () => {
  const [isEditMode, setIsEditMode] = useState(false);
  const [name, setName] = useState('John Doe');
  const [bio, setBio] = useState('Front-end Developer');
  const [location, setLocation] = useState('New York');

  const handleEditClick = () => {
    setIsEditMode(true);
  };

  const handleSaveClick = () => {
    setIsEditMode(false);
  };

  return (
    <div className="profile-container">
      <h2>Profile</h2>
      <div className={isEditMode ? 'edit-mode user-info' : 'view-mode user-info'}>
        {isEditMode ? (
          <div>
            <label>Name: </label>
            <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
            <br />
            <label>Bio: </label>
            <input type="text" value={bio} onChange={(e) => setBio(e.target.value)} />
            <br />
            <label>Location: </label>
            <input type="text" value={location} onChange={(e) => setLocation(e.target.value)} />
            <br />
            <button className="edit-profile-button" onClick={handleSaveClick}>
              Save
            </button>
          </div>
        ) : (
          <div>
            <p><strong>Name:</strong> {name}</p>
            <p><strong>Bio:</strong> {bio}</p>
            <p><strong>Location:</strong> {location}</p>
            <button className="edit-profile-button" onClick={handleEditClick}>
              Edit Profile
            </button>
          </div>
        )}
      </div>
    </div>
  );
};

export default Profile;



