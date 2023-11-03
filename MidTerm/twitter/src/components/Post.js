import React, { useState } from 'react';
import { Link, useParams, useNavigate } from 'react-router-dom';
import { posts } from '../data';
import '../Post.css';

const Post = () => {
  const { postId } = useParams();
  const post = posts.find((p) => p.id === Number(postId));
  const navigate = useNavigate(); 

  const [newText, setNewText] = useState(post ? post.text : '');

  const handleEditPost = () => {
  
    if (post) {
      post.text = newText;
    }

    navigate('/');
  };

  return (
    <div className="post-container">
      <h2>Edit Post</h2>
      <div className="input-container">
        <textarea
          value={newText}
          onChange={(e) => setNewText(e.target.value)}
          rows="4"
          placeholder="Edit your post..."
        />
        <button onClick={handleEditPost}>Save</button>
      </div>
      <Link to="/">Back to Feed</Link>
    </div>
  );
};

export default Post;


