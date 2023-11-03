import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import '../Feed.css';
import { posts } from '../data';

const Feed = () => {
  const [newPostText, setNewPostText] = useState('');
  const [feedPosts, setFeedPosts] = useState(posts);

  const handleAddPost = () => {
    if (newPostText) {
      const newPost = {
        id: feedPosts.length + 1,
        text: newPostText,
        likes: 0,
        dislikes: 0,
      };
      setFeedPosts([...feedPosts, newPost]);
      setNewPostText('');
    }
  };

  const handleLike = (postId) => {
    setFeedPosts((prevPosts) =>
      prevPosts.map((post) =>
        post.id === postId ? { ...post, likes: post.likes + 1 } : post
      )
    );
  };

  const handleDislike = (postId) => {
    setFeedPosts((prevPosts) =>
      prevPosts.map((post) =>
        post.id === postId ? { ...post, dislikes: post.dislikes + 1 } : post
      )
    );
  };

  const handleDeletePost = (postId) => {
    const updatedPosts = feedPosts.filter((post) => post.id !== postId);
    setFeedPosts(updatedPosts);
  };

  return (
    <div className="feed-container">
      <h2>Feed</h2>
      <div className="input-container">
        <input
          type="text"
          placeholder="What's happening?"
          value={newPostText}
          onChange={(e) => setNewPostText(e.target.value)}
        />
        <button onClick={handleAddPost}>Tweet</button>
      </div>
      <div>
        {feedPosts.map((post) => (
          <div key={post.id} className="tweet">
            <p className="tweet-text">{post.text}</p>
            <div className="tweet-buttons">
              <Link to={`/post/${post.id}`} className="tweet-button">
                Edit
              </Link>
              <button className="tweet-button" onClick={() => handleLike(post.id)}>
                Like: {post.likes}
              </button>
              <button className="tweet-button" onClick={() => handleDislike(post.id)}>
                Dislike: {post.dislikes}
              </button>
              <button className="tweet-button" onClick={() => handleDeletePost(post.id)}>
                Delete
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Feed;



